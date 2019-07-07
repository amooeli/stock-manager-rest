'use strict'

var app = angular.module('App', [ 'ui.bootstrap', 'App.controllers', 'App.services' ]);

app.constant("CONSTANTS", {
        stock : "/stock",
        stockUser : "/stock/user",
        stockUserAddAmount : "/stock/user/add",
        stockUserRemoveAmount : "/stock/user/remove",
    });