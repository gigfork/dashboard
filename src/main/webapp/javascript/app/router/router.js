// Generated by CoffeeScript 1.6.2
(function() {
  var __hasProp = {}.hasOwnProperty,
    __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

  define(["jquery", "backbone", "app/views/login", "app/views/home"], function($, Backbone, LoginView, HomeView) {
    var AppRouter, _ref;

    return AppRouter = (function(_super) {
      __extends(AppRouter, _super);

      function AppRouter() {
        _ref = AppRouter.__super__.constructor.apply(this, arguments);
        return _ref;
      }

      AppRouter.prototype.routes = {
        "": "index",
        "login": "home"
      };

      AppRouter.prototype.index = function() {
        return new LoginView({
          router: this
        });
      };

      AppRouter.prototype.home = function() {
        return new HomeView();
      };

      return AppRouter;

    })(Backbone.Router);
  });

}).call(this);
