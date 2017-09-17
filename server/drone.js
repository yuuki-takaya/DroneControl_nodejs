var RollingSpider = require("rolling-spider");
var keypress = require('keypress');
keypress(process.stdin);
 
process.stdin.setRawMode(true);
process.stdin.resume();
 
var ACTIVE = true;
var STEPS = 30;
var d = new RollingSpider({uuid:"00105fe400dc42dcb82558568d033cb6"}); //各々書き換えましょう。
 
function cooldown() {
  ACTIVE = false;
  setTimeout(function () {
    ACTIVE = true;
  }, STEPS);
}
 
d.connect(function () {
 
  d.setup(function () {
    console.log('Configured for Rolling Spider! ', d.name);
    d.flatTrim();
    d.startPing();
    d.flatTrim();
    setTimeout(function () {
      console.log(d.name + ' => SESSION START');
      ACTIVE = true;
    }, 1000);
 
  });
});

function flight(key) {
 
  console.log('got "keypress" => ', key);
 
  if (ACTIVE && key) {
 
    var param = {tilt:0, forward:0, turn:0, up:0};
 
    if (key.name === 'l') {
      console.log('land');
      d.land();
    } else if (key.name === 't') {
      console.log('takeoff');
      d.takeOff();
    } else if (key.name === 'h') {
      console.log('hover');
      d.hover();
    } else if (key.name === 'x') {
      console.log('disconnect');
      d.disconnect();
      process.stdin.pause();
      process.exit();
    }
 
    if (key.name === 'w') {
      d.forward({ steps: STEPS });
      console.log('front');
      cooldown();
    } else if (key.name === 'z') {
      d.backward({ steps: STEPS });
      console.log('back');
      cooldown();
    } else if (key.name === 's') {
      d.tiltRight({ steps: STEPS });
      console.log('right');
      cooldown();
    } else if (key.name === 'a') {
      d.tiltLeft({ steps: STEPS });
      console.log('left');
      cooldown();
    } else if (key.name === 'u') {
      d.up({ steps: STEPS });
      console.log('up');
      cooldown();
    } else if (key.name === 'd') {
      d.down({ steps: STEPS });
      console.log('down');
      cooldown();
    }
 
    if (key.name === 'm') {
      param.turn = 90;
      d.drive(param, STEPS);
      cooldown();
    }
    if (key.name === 'h') {
      param.turn = -90;
      d.drive(param, STEPS);
      cooldown();
    }
    if (key.name === 'f') {
      d.frontFlip();
      console.log('frontFlip');
      cooldown();
    }
    if (key.name === 'b') {
      d.backFlip();
      console.log('backFlip');
      cooldown();
    }
 
  }
}
// listen for the "keypress" event
process.stdin.on('keypress', function (ch, key) {
 
  console.log('got "keypress" => ', key);
 
  if (ACTIVE && key) {
 
    var param = {tilt:0, forward:0, turn:0, up:0};
 
    if (key.name === 'l') {
      console.log('land');
      d.land();
    } else if (key.name === 't') {
      console.log('takeoff');
      d.takeOff();
    } else if (key.name === 'h') {
      console.log('hover');
      d.hover();
    } else if (key.name === 'x') {
      console.log('disconnect');
      d.disconnect();
      process.stdin.pause();
      process.exit();
    }
 
    if (key.name === 'up') {
      d.forward({ steps: STEPS });
      cooldown();
    } else if (key.name === 'down') {
      d.backward({ steps: STEPS });
      cooldown();
    } else if (key.name === 'right') {
      d.tiltRight({ steps: STEPS });
      cooldown();
    } else if (key.name === 'left') {
      d.tiltLeft({ steps: STEPS });
      cooldown();
    } else if (key.name === 'u') {
      d.up({ steps: STEPS });
      cooldown();
    } else if (key.name === 'd') {
      d.down({ steps: STEPS });
      cooldown();
    }
 
    if (key.name === 'm') {
      param.turn = 90;
      d.drive(param, STEPS);
      cooldown();
    }
    if (key.name === 'h') {
      param.turn = -90;
      d.drive(param, STEPS);
      cooldown();
    }
    if (key.name === 'f') {
      d.frontFlip();
      cooldown();
    }
    if (key.name === 'b') {
      d.backFlip();
      cooldown();
    }
 
  }
});


const http = require('http');
var querystring = require('querystring');

const server = http.createServer(
    function (request, response) {
        response.writeHead(200, {'Content-Type': 'text/plain'});
        response.write('Hello World From Node.JS!!!');
        // console.log
        // response.end();

        var data = '';
        //readableイベントが発火したらデータにリクエストボディのデータを追加
        request.on('readable', function(chunk) {
            data += request.read();
        });
        //リクエストボディをすべて読み込んだらendイベントが発火する。
        request.on('end', function() {
            //パースする
            var key = querystring.parse(data);
            console.log(key);
            flight(key);
            response.end(data);
        });
    }
);
server.listen(4000);



