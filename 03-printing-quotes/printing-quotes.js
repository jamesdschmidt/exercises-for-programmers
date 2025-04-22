const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.question('What is the quote? ', (quote) => {
  rl.question('Who said it? ', (author) => {
    console.log(`${author} said "${quote}"`);
    rl.close();
  });
});