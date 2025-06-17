// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
import type { IAuthConfig } from 'ionic-appauth';

const oidcConfig: IAuthConfig = {
  client_id: 'n2gZCC9j29O1DlVTf5SScUcKOu0M5sxl',
  server_host: 'https://dev-0lnbp6kiqqkt3kyo.us.auth0.com/api/v2/',
  redirect_url: window.location.origin + '/callback',
  end_session_redirect_url: window.location.origin + '/logout',
  scopes: 'openid profile',
  pkce: true,
};

export const environment = {
  production: false,
  oidcConfig,
  audience: 'api://default',
  scheme: '.us.dev-0lnbp6kiqqkt3kyo',
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
