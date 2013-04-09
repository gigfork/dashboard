define ["jquery", "underscore", "backbone", "app/models/salesdata"], ($, _, Backbone, SalesData) ->
  'use strict'
  
  class SalesDataCollection extends Backbone.Collection

    url: ->
      "/api/salesdata/"

    model: SalesData