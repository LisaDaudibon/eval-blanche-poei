export const ALPHA_NUMERIC_REGEXP = /^[a-zA-Z0-9]*$/

export const getTrad = (key: string): string => {
  if (Object.hasOwn(I18n, key)) {
    return I18n[key]
  }

  return 'non traduit'
}

const I18n: Record<string, string> = {
  word: 'mot',
  description: 'description',
  hints: 'indices',
  email: 'e-mail',
  password: 'mot de passe'
}
