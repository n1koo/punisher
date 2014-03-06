# -*- mode: ruby -*-
# vi: set ft=ruby :
Vagrant.configure("2") do |config|
  nodes = {
    'badguy' => { :ip  => '10.30.30.3', :memory => 1024 }
  }

  nodes.each do |node_name, node_opts|
    config.vm.define node_name do |node_config|
      node_config.vm.hostname = "punisher#{node_name}-#{ENV['USER']}"
      node_config.vm.box = "centos-65-x64-virtualbox-nocm.box"
      node_config.vm.box_url = "http://puppet-vagrant-boxes.puppetlabs.com/centos-65-x64-virtualbox-nocm.box"

      node_config.vm.network :private_network, ip: node_opts[:ip]

      node_config.vm.provider "virtualbox" do |v|
        v.gui = true
        unless node_opts[:memory].nil?
          modifyvm_args = ['modifyvm', :id]
          modifyvm_args << '--memory' << node_opts[:memory].to_s
          v.customize(modifyvm_args)
        end
      end
    end
  end
end
