// Generated by CoffeeScript 1.6.2
(function() {
  var __hasProp = {}.hasOwnProperty,
    __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

  define(["jquery", "underscore", "backbone", "handlebars", "text!./../templates/graph.hbs", "chartsjs"], function($, _, Backbone, Handlebars, graphTemplate, Chartjs) {
    'use strict';
    var GraphView, _ref;

    return GraphView = (function(_super) {
      __extends(GraphView, _super);

      function GraphView() {
        _ref = GraphView.__super__.constructor.apply(this, arguments);
        return _ref;
      }

      GraphView.prototype.el = "#container";

      GraphView.prototype.template = Handlebars.compile(graphTemplate);

      GraphView.prototype.initialize = function() {
        return this.render();
      };

      GraphView.prototype.render = function() {
        var ctx, data;

        $(this.el).html(this.template);
        data = {
          labels: ["January", "February", "March", "April", "May", "June", "July"],
          datasets: [
            {
              fillColor: "rgba(255,252,75,1)",
              strokeColor: "rgba(255,120,75,1)",
              data: [65, 59, 90, 81, 56, 55, 40]
            }, {
              fillColor: "rgba(78,160,255,1)",
              strokeColor: "rgba(41,85,135,1)",
              data: [28, 48, 40, 19, 96, 27, 100]
            }
          ]
        };
        ctx = document.getElementById("myChart").getContext("2d");
        return new Chart(ctx).Bar(data);
      };

      return GraphView;

    })(Backbone.View);
  });

}).call(this);
