import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'cardSearch'
})
export class CardSearchPipe implements PipeTransform {
  transform(cards: any[], searchTerm: string): any[] {
    if (!cards || !searchTerm) {
      return cards;
    }
    searchTerm = searchTerm.toLowerCase();
    return cards.filter(card => {
      return (
        card.First_Name.toLowerCase().includes(searchTerm) ||
        card.Last_Name.toLowerCase().includes(searchTerm) ||
        card.Address.toLowerCase().includes(searchTerm) ||
        card.City.toLowerCase().includes(searchTerm) ||
        card.State.toLowerCase().includes(searchTerm) ||
        card.Order_Total.toLowerCase().includes(searchTerm)
      );
    });
  }
}