define ["jquery", "backbone", "app/views/login"], ($, Backbone, LoginView) ->
 
  class Workspace extends Backbone.Router
    routes:
      "" : "index"

    index: ->
      new LoginView()