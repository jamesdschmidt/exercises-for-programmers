const readline = require('readline');
const rl = readline.createInterface(process.stdin, process.stdout);

rl.question('What is the input string? ', (answer) => {
  console.log(`${answer} has ${answer.length} characters.`);
  rl.close();
});
