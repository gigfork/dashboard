set :application, "dashboard"
set :scm, "git"
set :repository, "git@github.com:rocky-jaiswal/dashboard.git"
set :branch, "master"

default_run_options[:pty] = true
ssh_options[:forward_agent] = true

task :dashboard do
    roles.clear
    server "192.168.1.6", :app
    set :user, "www" 
    set :deploy_to, "/home/#{user}/app/#{application}" # Line 18
    set :use_sudo, false
    set :tomcat_manager, "manager"
    set :tomcat_manager_password, "manager"
    namespace :tomcat do
      task :deploy do
        puts "==================Building with Maven======================"
        run "cd #{deploy_to}/current && mvn clean package"
        puts "==================Deploying with Manager======================"
        run "curl --upload-file #{deploy_to}/current/target/#{application}*.war --user #{tomcat_manager}:#{tomcat_manager_password} http://localhost:8080/manager/text/deploy?path=/ROOT"
      end
    end
    after "deploy", "tomcat:deploy"
    after "tomcat:deploy", "deploy:cleanup" # keep only the last 5 releases
end 