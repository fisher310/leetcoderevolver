nnoremap H ^
vnoremap H ^
nnoremap L $
vnoremap L $

set nu
set relativenumber
set nowrap
set mouse=a
set cmdheight=1
set wildmode=list

let mapleader = " "

map <leader>h :noh<CR>


nnoremap <leader>=f <Cmd>call VSCodeNotify('editor.action.formatDocument')<CR>
vnoremap <leader>=f <Cmd>call VSCodeNotify('editor.action.formatDocument')<CR>
nnoremap ? <Cmd>call VSCodeNotify('workbench.action.findInFiles', {'query': expand('<cword>')})<CR>


Plug 'asvetliakov/vim-easymotion', Cond(exists('g:vscode'), { 'as': 'vsc-easymotion' })
