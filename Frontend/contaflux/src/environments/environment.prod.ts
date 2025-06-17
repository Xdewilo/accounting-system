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
