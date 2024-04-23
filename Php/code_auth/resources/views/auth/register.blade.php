@extends('modele')

@section('contents')
    <p>Enregistrement</p>
    <form method="post">
        Login: <input type="text" name="login" value="{{old('login')}}">
        MDP: <input type="password" name="mdp">
        Confirmation MDP: : <input type="password" name="mdp_confirmation">
        <input type="submit" value="Envoyer">
        @csrf
    </form>
@endsection
