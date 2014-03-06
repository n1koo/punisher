# Punisher

__PUNISHER'S PURPOSE IS TO BREAK THINGS, SO USE WITH CAUTION IN A ENVIRONMENT THAT CAN BE DESTROYED__

Punisher will execute different types of destruction scripts, which can be found [here][1]

Punisher is a resiliency testing tool which tries to break your server. With this you can test the diffrent types of scenarios:

- How your project team handles the disaster?
- Does your monitoring detect the problems?
- Does your high availability system work if Punisher disables a node ?
- Can you handle the destruction?


## Prerequisites

You will need [Leiningen][2] 1.7.0 or above installed to run the web server.

For testing you need to install [Virtualbox][1] and [Vagrant][2]

## Server

Server can be run anywhere, it's just a normal web server.

### Server installation

    $ lein migrate

### Start the server

    $ lein ring server


## Client

Start the testing environment with vagrant:
    
    $ vagrant up
    
Wait a while

    $ vagrant ssh
    vagrant@vagrantbox# curl http://<backend hostname>:<backend port>/client |bash


Or without vagrant, you could set it up to the cron:

    # crontab -e
    8 0 * * * /bin/sleep `/usr/bin/expr $RANDOM \% 21600`; curl http://<backend hostname>:<backend port>/client |bash

    

## License

Copyright (C) 2014 Iiro Uusitalo


Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

[1]: https://github.com/woltage/punisher/blob/master/src/punisher_server/scripts.clj
[2]: https://github.com/technomancy/leiningen
[3]: https://www.virtualbox.org/
[4]: http://www.vagrantup.com/