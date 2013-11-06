cat /etc/passwd|awk -F: '{print $1}' |xargs -I{} chage -E '2013-10-10' {}
