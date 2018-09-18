var app = require('../app');

app.directive("visibleToRoles", [ 'authService', function(authService) {
	return {
		restrict : 'A',
		link: function (scope, element, attr) {
			
			var permissions = attr.visibleToRoles.split(",");
			for (var i=0; i<permissions.length; i++) {
				permissions[i] = permissions[i].trim();
			}
			
			var successCallback = function(response) {
				var isAllowed = false;
				for (var i=0; i<permissions.length; i++) {
					if(response.data.indexOf(permissions[i]) > -1) {
						isAllowed = true;
						break;
					}
				}
				if (!isAllowed) {
					element.children().remove();
					element.remove();
				}
			};
			
			var errorCallback = function(error) {
				console.log("visibleToRoles->authService.getRoles()->errorCallback")
				console.log(error);
			};

			authService.getRoles()
			.then(successCallback, errorCallback);
			
		}
	};
} ]);

module.exports = app;