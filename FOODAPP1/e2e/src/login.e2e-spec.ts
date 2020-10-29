import { browser, logging } from 'protractor';
import { LoginPage } from "./login.po";


describe('login page', () => {
  let page: LoginPage;

  beforeEach(() => {
    page = new LoginPage();
  });

  it('should get username input box', () => {
    page.navigateToLogin();
    expect(page.isUserNameInputBoxPresent())
    .toBeTruthy(`<input id="mail" formControlName='mail'> should exist in login.component.html`);
  });



  it('should get password input box', () => {
    page.navigateToLogin();
    expect(page.isPasswordInputBoxPresent())
    .toBeTruthy(`<input id="password" formControlName='password'> should exist in login.component.html`);
  });

  it('should get submit button', () => {
    page.navigateToLogin();
    expect(page.isSubmitButtonPresent()).toBeTruthy(`<button type="submit">Login</button> should
      exist in login.component.html`);
  })

  it('should login into the system', () => {
    page.navigateToLogin();
    let newUsers = page.addLoginValues();
    expect(page.getLoginInputBoxesDefaultValues()).toEqual(newUsers, 'Should be able to set values for username and password');
    page.clickSubmitButton();
    page.navigateToDashboard();
    page.getCurrentURL().then((url) => {
      if (url.indexOf('loginuser') > -1) {
        newUsers = page.addLoginValues();
        page.clickSubmitButton();
        page.navigateToDashboard();
        expect(page.getCurrentURL()).toContain('loginuser', 'Should navigate to dashboard');
      } else {
        expect(page.getCurrentURL()).toContain('loginuser', 'Should navigate to dashboard');
      }
    });
  });
});




  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
