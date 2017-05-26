import {Injectable} from "@angular/core";

@Injectable()
export class MapUtils{

    public static createPageRange(number){
        let items: number[] = [];
        for(let i = 0; i < number; i++){
            items.push(i);
        }
        return items;
    }
}