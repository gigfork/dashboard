set :application, "dashboard"
set :scm, "git"
set :repository, "git@githuben.intranet.mckinsey.com:Rocky-Jaiswal/dashboard.git"
set :branch, "master"
set :deploy_via, :remote_cache

default_run_options[:pty] = true
ssh_options[:forward_agent] = true

task :local do
    roles.clear
    server "localhost", :app
    set :user, "www" 
    set :deploy_to, "/home/#{user}/app/#{application}" # Line 18
    set :use_sudo, false
    namespace :tomcat do
      task :deploy do
        puts "==================Building and Deploying with Maven======================"
        run "cd #{deploy_to}/current && mvn clean package && mvn cargo:redeploy"
      end
    end
    after "deploy", "tomcat:deploy"
    after "tomcat:deploy", "deploy:cleanup" # keep only the last 5 releases
end 