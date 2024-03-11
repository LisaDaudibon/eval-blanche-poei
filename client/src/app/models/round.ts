export class Round {
  constructor(public id: string, public attempt: number, public lettersAnswered: string[], public state: string, public wordGuessed: string) {}
}
