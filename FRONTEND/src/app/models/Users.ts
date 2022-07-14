export class Users {
    id!: number;
    firstName!: string;
    lastName!: string;
    userName!: string;
    password!:string;
    role!: UserRole;
    email!: string;
    address!: string;
    aboutMe!: string;
    time!: TimeofDay;
    day!: Days;
    service!: ServiceOffered;
   price!: number;
   description!: string;

}
export enum ServiceOffered{
    Petgrooming,
    Dogwalking,
    Petsetting,
    All
}
export enum UserRole {
    Contractor,
    Customer
}

export enum Categories{
    Walking,
    Grooming,
    DayCare
}

export enum Days{
    Weekends, 
    WeekDays, 
    AnyDay


}
export enum TimeofDay{

    Morning,
    Afternoon,
    night,
    Anytime

}
