import { Component, OnInit } from '@angular/core';
import { ContentfulService } from '../services/contentful.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  constructor(private contentfulService: ContentfulService) { }

  blogPosts$: Observable<any> | undefined;
  ngOnInit(): void {
    this.blogPosts$ = this.contentfulService.getAllEntries();
  }

}
