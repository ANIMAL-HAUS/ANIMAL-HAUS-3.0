import { ServiceOffered } from "./Users";

export class Cart {
    id!: number;
    username!: string;
    service!: ServiceOffered;
    contractorFirstName!: string;
    contractorLastName!: string;
    price!: number;
}