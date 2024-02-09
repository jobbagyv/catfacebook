import { APP_INITIALIZER, ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes';
import { provideHttpClient, withInterceptors } from '@angular/common/http';
import { AuthConfig, OAuthService, provideOAuthClient } from 'angular-oauth2-oidc';
import { authHeaderInterceptor } from '../interceptors/auth-header.interceptor';

export const authFlowCodeConfig : AuthConfig = {
  issuer: 'http://localhost:8002/realms/Home',
  tokenEndpoint: 'http://localhost:8002/realms/Home/protocol/openid-connect/token',
  redirectUri: 'http://localhost:4200/home',
  clientId: 'login-app',
  responseType: 'code',
  scope: 'openid profile'
}

function initializeOAuth(oauthService: OAuthService): Promise<void>{
  return new Promise((resolve)=>{
    oauthService.configure(authFlowCodeConfig);
    oauthService.setupAutomaticSilentRefresh();
    oauthService.loadDiscoveryDocumentAndLogin().then(()=>{
      resolve();
    })
  });
}

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes), provideHttpClient(withInterceptors([authHeaderInterceptor])), provideOAuthClient(),
  {
    provide:  APP_INITIALIZER,
    useFactory: (oauthService: OAuthService) => {
      return () : Promise<any> => initializeOAuth(oauthService);
    },
    multi: true,
    deps:[
      OAuthService
    ]
  }]
};

export interface TestInterface{
  afterAuthInitialized: () => void;
}
