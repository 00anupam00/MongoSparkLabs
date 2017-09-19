import { Component } from '@angular/core';
import { Hero } from './hero';
import { HeroDetailComponent } from './hero-detail.component';
import { HeroService } from './hero.service';
import { OnInit } from "@angular/core";
import { Router } from "@angular/router";

@Component({
    selector: 'my-heroes',
    templateUrl: './heroes.component.html',
    styleUrls: ['./heroes.component.css'],
    providers : []
})

export class HeroesComponent implements OnInit {
    title = 'Tour of Heroes';
    heroes: Hero[];
    selectedHero : Hero;

    ngOnInit(): void{
      this.getHeroes();
    }

    constructor(
      private router: Router,
      private heroService: HeroService){}

    onSelect(hero : Hero): void{
        this.selectedHero = hero;
    }

    getHeroes() :void {
      this.heroService.getHeroes().then(heroes => this.heroes = heroes);
    }

    getHeroesSlowly(): void {
      this.heroService.getHeroesSlowly();
    }

    gotoDetails() : void{
      this.router.navigate(['/detail', this.selectedHero.id]);
    }
}



