import { MongoSparkPage } from './app.po';

describe('mongo-spark App', function() {
  let page: MongoSparkPage;

  beforeEach(() => {
    page = new MongoSparkPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
