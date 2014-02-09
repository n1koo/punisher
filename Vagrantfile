# -*- mode: ruby -*-
# vi: set ft=ruby :
Vagrant.configure("2") do |config|
  nodes = {
    'badguy' => { :ip  => '10.30.30.3' }
  }

  nodes.each do |node_name, node_opts|
    config.vm.define node_name do |node_config|
      node_config.vm.hostname = "punisher#{node_name}-berkshelf-#{ENV['USER']}"
      node_config.vm.box = "centos-64-x64-vbox4210-nocm"
      node_config.vm.box_url = "http://puppet-vagrant-boxes.puppetlabs.com/centos-64-x64-vbox4210-nocm.box"
      node_config.cache.enable :yum

      node_config.vm.network :private_network, ip: node_opts[:ip]

      node_config.vm.synced_folder(".", nil, :disabled => true, :id => "vagrant-root")

      node_config.vm.provider "virtualbox" do |v|
        v.gui = false
        unless node_opts[:memory].nil?
          modifyvm_args = ['modifyvm', :id]
          modifyvm_args << '--memory' << node_opts[:memory].to_s
          v.customize(modifyvm_args)
        end
      end
    end
  end
end
