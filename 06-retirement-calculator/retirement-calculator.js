const readline = require('readline');
const rl = readline.createInterface(process.stdin, process.stdout);

rl.question('What is your current age? ', (answer) => {
  const currentAge = parseInt(answer);
  rl.question('At what age would you like to retire? ', (answer) => {
    const retireAge = parseInt(answer);

    const yearsLeft = retireAge - currentAge;
    const currentYear = new Date().getFullYear();
    const retireYear = currentYear + yearsLeft;

    if (yearsLeft < 1) {
      console.log(`You can already retire!`);
    } else {
      console.log(`You have ${yearsLeft} years left until you can retire.\nIt's ${currentYear}, so you can retire in ${retireYear}.`);
    }

    rl.close();
  });
});