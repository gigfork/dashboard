define ["jquery", "underscore", "backbone", "handlebars", "text!./../templates/home.hbs", "text!./../templates/uploadmessage.hbs", "ajaxForm"], ($, _, Backbone, Handlebars, homeTemplate, uploadMessage, ajaxForm) ->
  'use strict'
  
  class HomeView extends Backbone.View
    
    el: "#container"

    events:
      "submit #upload-form":  "handleSubmit"

    template: Handlebars.compile(homeTemplate)

    initialize: ->
      @render()

    render: ->
      $(@el).html(@template)

    handleSubmit: (e) ->
      e.preventDefault()
      $("#upload-form").ajaxSubmit({success: @handleUpload})

    handleUpload: (response, status, xhr, form) ->
      $(".message").append Handlebars.compile(uploadMessage)(response)
      $(".message").slideDown() #is hidden by default
