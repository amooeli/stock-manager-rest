'use strict'

angular.module('App.services', []).factory('UserService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};

            service.getUser = function(id) {
                var url = CONSTANTS.stockUser + '/' + id;
                return $http.get(url);
            }

			service.addToBalance = function(user, amount) {
                return $http.post(CONSTANTS.stockUserAddAmount + '/' + amount, user)
			}

            service.removeFromBalance = function(user, amount) {
                return $http.post(CONSTANTS.stockUserRemoveAmount + '/' + amount, user)
            }

            service.getStockInfo = function(s) {
                var url = CONSTANTS.stock + '/' + s;
                return $http.get(url);
            }
			return service;
		} ]);
