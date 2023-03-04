export const oktaConfig = {
  oidc: {
    clientId: process.env.REACT_APP_OKTA_ID,
    issuer: process.env.REACT_APP_OKTA_URL,
    redirectUri: 'http://localhost:3000/login/callback',
    scopes: ['openid', 'profile', 'email'],
    pkce: true,
    disableHttps: true,
  },
  widget: {
    clientId: process.env.REACT_APP_OKTA_ID,
    issuer: process.env.REACT_APP_OKTA_URL,
    redirectUri: 'http://localhost:3000/login/callback',
    scopes: ['openid', 'profile', 'email'],
    pkce: true,
    disableHttps: true,
  },
};
