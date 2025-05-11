const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on('line', function (line) {
  input = [line];
  rl.close();
}).on('close', function () {
  const str = input[0];
  let result = '';

  for (let ch of str) {
    if (ch >= 'A' && ch <= 'Z') {
      result += ch.toLowerCase();
    } else if (ch >= 'a' && ch <= 'z') {
      result += ch.toUpperCase();
    } else {
      result += ch;
    }
  }

  console.log(result);
});
