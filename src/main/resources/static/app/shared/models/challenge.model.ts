export class Challenge {
    id: number;
    name: string;
    description: string;
    status: string;
    category: string;
    // points: number;
    rewardType: string;
    rewartQuantity: string;
    idCreator: number;


    constructor(id: number, name: string, description: string, status: string, category: string, //points: number,
                rewardType: string, rewardQuantity: string, idcreator: number) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.category = category;
        // this.points = points;
        this.rewardType = rewardType;
        this.rewartQuantity = rewardQuantity;
        this.idCreator = idcreator;
    }


}