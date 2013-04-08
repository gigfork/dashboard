define ["jquery", "underscore", "backbone", "handlebars", "text!./../templates/graph.hbs", "chartsjs"], ($, _, Backbone, Handlebars, graphTemplate, Chartjs) ->
  'use strict'

  class GraphView extends Backbone.View

    el: "#container"

    template: Handlebars.compile(graphTemplate)

    initialize: ->
      @render()

    render: ->
      $(@el).html(@template)
      data =
        labels: ["January", "February", "March", "April", "May", "June", "July"]
        datasets: [
          fillColor: "rgba(255,252,75,1)"
          strokeColor: "rgba(255,120,75,1)"
          data: [65, 59, 90, 81, 56, 55, 40]
        ,
          fillColor: "rgba(78,160,255,1)"
          strokeColor: "rgba(41,85,135,1)"
          data: [28, 48, 40, 19, 96, 27, 100]
        ]
      ctx = document.getElementById("myChart").getContext("2d")
      new Chart(ctx).Bar(data)
