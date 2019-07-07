'use strict'

var module = angular.module('App.controllers', []);

module.controller("StockManagerController", [ "$scope", "UserService",
		function($scope, UserService) {

            $scope.stockSymbols = ["AAPL", "CXSE", "GOOG", "PRESS"];
            $scope.stockName = null;
            $scope.stockPrice = null;
            $scope.stockQuantity = null;
            $scope.selectedSymbol = null;

            $scope.user = {
                id : null,
				userId : null,
                firstName : null,
				lastName : null,
                cashBalance : null,
                numberOfShares : null,
				portfolios : [{id: null, symbol: null, price: null}]
			};
            $scope.portfolios = [];
            $scope.amount = null;

            $scope.getStockInfo = function() {
                UserService.getStockInfo($scope.selectedSymbol).then(function (value) {
                    $scope.stockName = value.data.name;
                    $scope.stockPrice = value.data.price;
                }, function (reason) {
                    console.log("error occured");
                }, function (value) {
                    console.log("no callback");
                });
            }

            $scope.getUser = function() {
                UserService.getUser(1).then(function (result) {
                    $scope.user = result.data;
                }, function (reason) {
                    console.log("error occured");
                }, function (value) {
                    console.log("no callback");
                });
            }

            $scope.addToBalance = function() {
                if ($scope.amount > 0) {
                    UserService.addToBalance($scope.user, $scope.amount).then(function (result) {
                        $scope.user = result.data;
                        $scope.amount = null;
                    }, function (reason) {
                        console.log("error occured");
                    }, function (value) {
                        console.log("no callback");
                    });
                } else {
                    alert("Please specify the amount to be added to your cash balance!");
                }
            }

			$scope.removeFromBalance = function() {
                if ($scope.amount > 0) {
                    UserService.removeFromBalance($scope.user, $scope.amount).then(function (result) {
                        $scope.user = result.data;
                        $scope.amount = null;
                    }, function (reason) {
                        console.log("error occured");
                    }, function (value) {
                        console.log("no callback");
                    });
                } else {
                    alert("Please specify the amount to be removed from your cash balance!");
                }
			}

            $scope.buyStock = function() {
                if ($scope.stockQuantity > 0 && $scope.stockPrice > 0) {
                    $scope.user.numberOfShares += $scope.stockQuantity;
                    UserService.removeFromBalance($scope.user, $scope.stockQuantity * $scope.stockPrice).then(function (result) {
                        $scope.user = result.data;
                    }, function (reason) {
                        console.log("error occured");
                    }, function (value) {
                        console.log("no callback");
                    });
                } else {
                    alert("Please specify the quantity or maybe the stock price is empty!");
                }
            }

            $scope.sellStock = function() {
                if ($scope.stockQuantity > 0 && $scope.stockPrice > 0) {
                    $scope.user.numberOfShares -= $scope.stockQuantity;
                    UserService.addToBalance($scope.user, $scope.stockQuantity * $scope.stockPrice).then(function (result) {
                        $scope.user = result.data;
                    }, function (reason) {
                        console.log("error occured");
                    }, function (value) {
                        console.log("no callback");
                    });
                } else {
                    alert("Please specify the quantity or maybe the stock price is empty!");
                }
            }
		} ]);