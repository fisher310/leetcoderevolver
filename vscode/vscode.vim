nnoremap H ^
vnoremap H ^
nnoremap L $
vnoremap L $

set nu
set relativenumber
set nowrap
set mouse=a
" set cmdheight=1
set wildmode=list

let mapleader = " "

" map <leader>h :noh<CR>
inoremap jj <ESC>
inoremap jk <ESC>la
inoremap j; <ESC>A;<ESC>




nnoremap <leader>=f <Cmd>call VSCodeNotify('editor.action.formatDocument')<CR>
vnoremap <leader>=f <Cmd>call VSCodeNotify('editor.action.formatDocument')<CR>
nnoremap ? <Cmd>call VSCodeNotify('workbench.action.findInFiles', {'query': expand('<cword>')})<CR>

nnoremap <leader>tt <Cmd>call VSCodeNotify('testing.debugAtCursor')<CR>
nnoremap <leader>ta <Cmd>call VSCodeNotify('editor.debug.action.runToCursor')<CR>
nnoremap mm <Cmd>call VSCodeNotify('bookmarks.toggle')<CR>
nnoremap ma <Cmd>call VSCodeNotify('bookmarks.list')<CR>


