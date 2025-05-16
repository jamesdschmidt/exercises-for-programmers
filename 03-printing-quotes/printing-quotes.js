const readline = require('readline');
const rl = readline.createInterface(process.stdin, process.stdout);

rl.question('What is the quote? ', (quote) => {
  rl.question('Who said it? ', (author) => {
    console.log(`${author} said "${quote}"`);
    rl.close();
  });
});
