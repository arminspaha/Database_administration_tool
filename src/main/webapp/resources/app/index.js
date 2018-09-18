var jquery = require('jquery');
var angular = require('angular');

var glyphs = require('glyphs');

require('angular-toastr');
require('@uirouter/angularjs');
require('./app-login');
require('./app');


// controllers
require('./home-controller');
require('./view/user-list-controller');
require('./profile/profile-controller');
require('./entries/entries-controller');
require('./authentication/login-controller');

// directives
require('./view/tr-row-directive');
require('./authentication/visible-to-roles-directive');

//services
require('./view/data-service');
require('./authentication/auth-service');
require('./profile/profile-service');