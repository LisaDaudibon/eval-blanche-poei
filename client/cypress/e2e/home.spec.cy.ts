import round from '../fixtures/round.json'

describe('Homepage tests', () => {

  beforeEach(() => {
    cy.visit('/')
  })

  it('should display Homepage', () => {
    cy.contains('Créer un jeu')
  })

  it('should create a new round', () => {
    const gameId = '7f0f5d04-d957-4198-9a16-5c09016c5def'
    const gameDescription = 'Famille gothique très célèbre'

    //prevent intering the data into the db
    cy.intercept({
      method: 'POST',
      url: `api/games/${gameId}/rounds`
    }, {
      statusCode: 201
    })

    cy.intercept(`/api/rounds/${round.id}`, {
      statusCode: 200,
      fixture: 'round.json'
    })

    cy.get('app-create-round-button')
      .find('.btn')
      .contains(`Nouvelle partie : ${gameDescription}`)
      .click();
  

    cy.url().should('contains', `/rounds`)
  })

  it('should display the games correctly', () => {
    cy.visit('/')
    cy.get('app-create-round-button').contains('Un petit animal très mignon')
  })

  it('should redirect to round page with correct id', () => {
    const gameId = '7f0f5d04-d957-4198-9a16-5c09016c5def'

    cy.intercept(`/api/games/${gameId}/rounds`, {
      statusCode: 200,
      fixture: 'round.json'
    })
    
    cy.intercept(`/api/rounds/${round.id}`, {
      statusCode: 200,
      fixture: 'round.json'
    })

    cy.get(".col-4").eq(10).contains( '.btn', round.description).click();

    cy.url().should('contains', `rounds/${round.id}`)
  })
})