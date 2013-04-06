// Generated by CoffeeScript 1.6.2
(function() {
  var __hasProp = {}.hasOwnProperty,
    __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

  define(["jquery", "backbone", "app/views/login"], function($, Backbone, LoginView) {
    var Workspace, _ref;

    return Workspace = (function(_super) {
      __extends(Workspace, _super);

      function Workspace() {
        _ref = Workspace.__super__.constructor.apply(this, arguments);
        return _ref;
      }

      Workspace.prototype.routes = {
        "": "index"
      };

      Workspace.prototype.index = function() {
        return new LoginView();
      };

      return Workspace;

    })(Backbone.Router);
  });

}).call(this);
