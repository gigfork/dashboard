define ["jquery", "underscore", "backbone", "handlebars", "text!./../templates/graph.hbs", "chartsjs"], ($, _, Backbone, Handlebars, graphTemplate, Chartjs) ->
  'use strict'

  class GraphView extends Backbone.View

    el: "#container"

    template: Handlebars.compile(graphTemplate)

    initialize: ->
      @render()

    render: ->
      $(@el).html(@template)
      @collection.fetch({async: false})
      @drawGraph()

    drawGraph: ->
      data = 
        labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
        datasets: [
          fillColor: "rgba(255,252,75,1)"
          strokeColor: "rgba(255,120,75,1)"
          data: @getAnnualData(2011)
        ,
          fillColor: "rgba(78,160,255,1)"
          strokeColor: "rgba(41,85,135,1)"
          data: @getAnnualData(2012)
        ]
      ctx = document.getElementById("myChart").getContext("2d")
      new Chart(ctx).Bar(data, {scaleShowGridLines : false})

    getAnnualData: (year) ->
      annualData = _.filter @collection.models, (dataset) ->
        dataset.get("yearOfSale") is year
      _.map(annualData, (model) -> model.get("unitsOfSale"))