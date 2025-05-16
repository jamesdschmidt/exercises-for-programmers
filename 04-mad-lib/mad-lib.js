const readline = require('readline');
const rl = readline.createInterface(process.stdin, process.stdout);

rl.question('Enter a noun: ', (noun) => {
  rl.question('Enter a verb: ', (verb) => {
    rl.question('Enter an adjective: ', (adjective) => {
      rl.question('Enter an adverb: ', (adverb) => {
        console.log(`Do you ${verb} ${adjective} ${noun} ${adverb}? That's hilarious!`);
        rl.close();
      });
    });
  });
});
