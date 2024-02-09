import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { OAuthService } from 'angular-oauth2-oidc';

export const authHeaderInterceptor: HttpInterceptorFn = (req, next) => {
    const oauthService = inject(OAuthService);
    if(req.url.startsWith('http://localhost:8080')){
      const clonedRequest = req.clone({ headers: req.headers.append('Authorization', oauthService.authorizationHeader()) });
      return next(clonedRequest);
    } else {
      return next(req);
    }
};
