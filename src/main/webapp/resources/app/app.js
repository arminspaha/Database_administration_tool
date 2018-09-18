var app = angular.module('app', ['ui.router', 'toastr']);

app.config(function($stateProvider, $urlRouterProvider) {

  var createState = function(alias, params) {
    $stateProvider.state(alias, params);
  };

  createState("userList", {url: "/", templateUrl: './resources/app/view/templates/view.html'});
  createState("profile", {url: "/profile", templateUrl: './resources/app/profile/templates/view.html'});
  createState("entries", {url: "/entries", templateUrl: './resources/app/entries/templates/view.html'
  });


  $urlRouterProvider.otherwise('/');
});

module.exports = app;