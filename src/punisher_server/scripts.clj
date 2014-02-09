(ns punisher-server.scripts)

(def all-scripts
  [
   {
    :level 1
    :desc ""
    :script "iptables -A OUTPUT -p udp --dport 53 -j DROP"
   }
   {
    :level 1
    :desc ""
    :script "ip route del default && ip route add default via 127.0.0.1"
   }
   {
    :level 1
    :desc ""
    :script "hostname localhost"
   }
   {
    :level 1
    :desc ""
    :script "echo '' > /etc/resolv.conf"
   }
   {
    :level 1
    :desc "Flushes the firewall"
    :script "iptables -F"
   }
   {
    :level 1
    :desc "Drop interface eth0"
    :script "ifconfig eth0 down"
  }])
