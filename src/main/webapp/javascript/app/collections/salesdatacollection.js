// Generated by CoffeeScript 1.6.2
(function() {
  var __hasProp = {}.hasOwnProperty,
    __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

  define(["jquery", "underscore", "backbone", "app/models/salesdata"], function($, _, Backbone, SalesData) {
    'use strict';
    var SalesDataCollection, _ref;

    return SalesDataCollection = (function(_super) {
      __extends(SalesDataCollection, _super);

      function SalesDataCollection() {
        _ref = SalesDataCollection.__super__.constructor.apply(this, arguments);
        return _ref;
      }

      SalesDataCollection.prototype.url = function() {
        return "/api/salesdata/";
      };

      SalesDataCollection.prototype.model = SalesData;

      return SalesDataCollection;

    })(Backbone.Collection);
  });

}).call(this);
