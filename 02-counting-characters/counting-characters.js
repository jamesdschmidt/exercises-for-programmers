const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.question('What is the input string? ', (line) => {
  console.log(`${line} has ${line.length} characters.`);
  rl.close();
});
