define ["jquery", "backbone", "app/views/login", "app/views/home"], ($, Backbone, LoginView, HomeView) ->
 
  class AppRouter extends Backbone.Router
    
    routes:
      "" : "index"
      "login" : "home"

    index: ->
      new LoginView({router: @})

    home: ->
      new HomeView()